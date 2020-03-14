package com.bbdemo.provider;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
public class AliyunProvider {
    @Value("${Aliyun-AccessKeyID}")
    private String AccessKeyID;
    @Value("${Aliyun-AccessKeySecret}")
    private String AccessKeySecret;
    @Value("${Aliyun-endpoint}")
    private String endpoint;
    @Value("${Aliyun-bucketName}")
    private String bucketName;

    public String upload(InputStream inputStream, String mineType, String fileName) {
        String ObjectName;
        String[] filePaths = fileName.split("\\.");
        if (filePaths.length > 1) {
            ObjectName = UUID.randomUUID().toString() + "." + filePaths[filePaths.length - 1];
        } else {
            throw new CustomizeException(CustomizeErrorCode.IMAGE_UPLOAD_FALSE);
        }
        OSS ossClient = new OSSClientBuilder().build(endpoint, AccessKeyID, AccessKeySecret);
        // 创建PutObjectRequest对象。
        String content = "Hello OSS";
        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, ObjectName, inputStream);
        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);
        // 上传字符串。
        ossClient.putObject(putObjectRequest);
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 365);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(bucketName, ObjectName, expiration);
        // 关闭OSSClient。
        ossClient.shutdown();
        return url.toString();
    }
}
