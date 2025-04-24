// // // package com.music.services;

// // // import java.io.IOException;
// // // import java.util.ArrayList;
// // // import java.util.List;
// // // import java.util.stream.Collectors;

// // // import com.amazonaws.services.s3.model.*;
// // // import org.springframework.stereotype.Service;

// // // import com.amazonaws.auth.AWSCredentialsProvider;
// // // import com.amazonaws.auth.AWSStaticCredentialsProvider;
// // // import com.amazonaws.auth.BasicAWSCredentials;
// // // import com.amazonaws.client.builder.AwsClientBuilder;
// // // import com.amazonaws.services.s3.AmazonS3;
// // // import com.amazonaws.services.s3.AmazonS3ClientBuilder;
// // // import org.springframework.web.multipart.MultipartFile;


// // // @Service
// // // public class StorageService{
// // //     private final AmazonS3 space;

// // //     public StorageService(){
// // //         AWSCredentialsProvider awsCredentialsProvider=new AWSStaticCredentialsProvider(
// // //             new BasicAWSCredentials("DO00YN8HLAE4Q4J9QREC", "W7vy35hK9rHASFIVptfgUo/6jfjuyGmkESTTGY1dvnE")
// // //         );
// // //         space=AmazonS3ClientBuilder.standard()
// // //             .withCredentials(awsCredentialsProvider)
// // //             .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sfo3.digitaloceanspaces.com", "sfo3"))
// // //             .build();
// // //     }

// // //     public List<String> getSongFileNames(){
// // //         ListObjectsV2Result result=space.listObjectsV2("musicarchive1");
// // //         List<S3ObjectSummary> objects=result.getObjectSummaries();
// // //         return objects.stream()
// // //                 .map(s3ObjectSummary -> {
// // //                     return s3ObjectSummary.getKey();
// // //                 }).collect(Collectors.toList());

// // //         }
// // //         public List<String> getSongQueue(){
// // //             List<String> c = new ArrayList<String>();
// // //             c.add("01 Jimpak Chipak.mp3");
// // //             c.add("Flowers.mp3");
// // //             c.add("test2.mp3");
// // //             return c;
// // //         }

// // //     public void uploadSong(MultipartFile file) throws IOException {
// // //         ObjectMetadata objectMetadata = new ObjectMetadata();
// // //         objectMetadata.setContentType(file.getContentType());
// // //         space.putObject(new PutObjectRequest("musicarchive1",file.getOriginalFilename(),file.getInputStream(),objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
// // //     }
// // // }

// // package com.music.services;

// // import java.io.IOException;
// // import java.util.ArrayList;
// // import java.util.List;
// // import java.util.stream.Collectors;

// // import com.amazonaws.services.s3.model.*;
// // import org.springframework.stereotype.Service;

// // import com.amazonaws.auth.AWSCredentialsProvider;
// // import com.amazonaws.auth.AWSStaticCredentialsProvider;
// // import com.amazonaws.auth.BasicAWSCredentials;
// // import com.amazonaws.client.builder.AwsClientBuilder;
// // import com.amazonaws.services.s3.AmazonS3;
// // import com.amazonaws.services.s3.AmazonS3ClientBuilder;
// // import org.springframework.web.multipart.MultipartFile;

// // @Service
// // public class StorageService {
// //     private AmazonS3 space;
// //     private boolean s3Enabled = false; // Added flag to control S3 functionality

// //     public StorageService() {
// //         // Comment out S3 initialization for now
// //         /*
// //         AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
// //             new BasicAWSCredentials("DO00YN8HLAE4Q4J9QREC", "W7vy35hK9rHASFIVptfgUo/6jfjuyGmkESTTGY1dvnE")
// //         );
// //         space = AmazonS3ClientBuilder.standard()
// //             .withCredentials(awsCredentialsProvider)
// //             .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sfo3.digitaloceanspaces.com", "sfo3"))
// //             .build();
// //         */
// //     }

// //     public List<String> getSongFileNames() {
// //         // Return dummy data instead of accessing S3
// //         List<String> mockSongs = new ArrayList<>();
// //         mockSongs.add("Sample1.mp3");
// //         mockSongs.add("Sample2.mp3");
// //         mockSongs.add("Sample3.mp3");
// //         return mockSongs;
        
// //         /* Original S3 code
// //         ListObjectsV2Result result = space.listObjectsV2("musicarchive1");
// //         List<S3ObjectSummary> objects = result.getObjectSummaries();
// //         return objects.stream()
// //                 .map(s3ObjectSummary -> {
// //                     return s3ObjectSummary.getKey();
// //                 }).collect(Collectors.toList());
// //         */
// //     }

// //     public List<String> getSongQueue() {
// //         List<String> c = new ArrayList<String>();
// //         c.add("01 Jimpak Chipak.mp3");
// //         c.add("Flowers.mp3");
// //         c.add("test2.mp3");
// //         return c;
// //     }

// //     public void uploadSong(MultipartFile file) throws IOException {
// //         if (!s3Enabled) {
// //             System.out.println("S3 storage is disabled. File would have been saved: " + file.getOriginalFilename());
// //             return;
// //         }
        
// //         // Original upload code
// //         ObjectMetadata objectMetadata = new ObjectMetadata();
// //         objectMetadata.setContentType(file.getContentType());
// //         space.putObject(new PutObjectRequest("musicarchive1", file.getOriginalFilename(), file.getInputStream(), objectMetadata)
// //                 .withCannedAcl(CannedAccessControlList.PublicRead));
// //     }
// // }

// package com.music.services;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import com.amazonaws.services.s3.model.*;
// import org.springframework.stereotype.Service;

// import com.amazonaws.auth.AWSCredentialsProvider;
// import com.amazonaws.auth.AWSStaticCredentialsProvider;
// import com.amazonaws.auth.BasicAWSCredentials;
// import com.amazonaws.client.builder.AwsClientBuilder;
// import com.amazonaws.services.s3.AmazonS3;
// import com.amazonaws.services.s3.AmazonS3ClientBuilder;
// import org.springframework.web.multipart.MultipartFile;

// @Service
// public class StorageService {
//     private AmazonS3 space;
//     private boolean s3Enabled = false; // Added flag to control S3 functionality

//     public StorageService() {
//         // Comment out S3 initialization for now
//         /*
//         AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
//             new BasicAWSCredentials("DO00YN8HLAE4Q4J9QREC", "W7vy35hK9rHASFIVptfgUo/6jfjuyGmkESTTGY1dvnE")
//         );
//         space = AmazonS3ClientBuilder.standard()
//             .withCredentials(awsCredentialsProvider)
//             .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sfo3.digitaloceanspaces.com", "sfo3"))
//             .build();
//         */
//     }

//     public List<String> getSongFileNames() {
//         // Return dummy data instead of accessing S3
//         List<String> mockSongs = new ArrayList<>();
//         mockSongs.add("Sample1.mp3");
//         mockSongs.add("Sample2.mp3");
//         mockSongs.add("Sample3.mp3");
//         return mockSongs;

//         /* Original S3 code
//         ListObjectsV2Result result = space.listObjectsV2("musicarchive1");
//         List<S3ObjectSummary> objects = result.getObjectSummaries();
//         return objects.stream()
//                 .map(s3ObjectSummary -> {
//                     return s3ObjectSummary.getKey();
//                 }).collect(Collectors.toList());
//         */
//     }

//     public List<String> getSongQueue() {
//         List<String> c = new ArrayList<String>();
//         c.add("01 Jimpak Chipak.mp3");
//         c.add("Flowers.mp3");
//         c.add("test2.mp3");
//         return c;
//     }

//     public void uploadSong(MultipartFile file) throws IOException {
//         if (!s3Enabled) {
//             System.out.println("S3 storage is disabled. File would have been saved: " + file.getOriginalFilename());
//             return;
//         }

//         // Original upload code
//         ObjectMetadata objectMetadata = new ObjectMetadata();
//         objectMetadata.setContentType(file.getContentType());
//         space.putObject(new PutObjectRequest("musicarchive1", file.getOriginalFilename(), file.getInputStream(), objectMetadata)
//                 .withCannedAcl(CannedAccessControlList.PublicRead));
//     }
// }

package com.music.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

@Service
public class StorageService {
    private AmazonS3 space;
    private boolean s3Enabled = false; // Flag to control S3 functionality
    private List<String> localQueue = new ArrayList<>(); // Local queue for songs when S3 is disabled

    public StorageService() {
        // Try to initialize S3 client only if credentials are valid
        try {
            AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("DO00YN8HLAE4Q4J9QREC", "W7vy35hK9rHASFIVptfgUo/6jfjuyGmkESTTGY1dvnE")
            );
            space = AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("sfo3.digitaloceanspaces.com", "sfo3"))
                .build();
            
            // Test connection
            space.listBuckets();
            s3Enabled = true;
            System.out.println("S3 storage initialized successfully");
        } catch (Exception e) {
            System.out.println("S3 storage initialization failed: " + e.getMessage());
            System.out.println("Using local storage instead");
            s3Enabled = false;
        }
    }

    public List<String> getSongFileNames() {
        if (s3Enabled) {
            try {
                ListObjectsV2Result result = space.listObjectsV2("musicarchive1");
                List<S3ObjectSummary> objects = result.getObjectSummaries();
                List<String> songNames = new ArrayList<>();
                for (S3ObjectSummary obj : objects) {
                    songNames.add(obj.getKey());
                }
                return songNames;
            } catch (Exception e) {
                System.out.println("Failed to retrieve songs from S3: " + e.getMessage());
                return getMockSongs();
            }
        } else {
            return getMockSongs();
        }
    }

    private List<String> getMockSongs() {
        // Return static mock data
        List<String> mockSongs = new ArrayList<>();
        mockSongs.add("Sample1.mp3");
        mockSongs.add("Sample2.mp3");
        mockSongs.add("Sample3.mp3");
        return mockSongs;
    }

    public List<String> getSongQueue() {
        if (localQueue.isEmpty()) {
            // Initialize with default values if empty
            localQueue.add("01 Jimpak Chipak.mp3");
            localQueue.add("Flowers.mp3");
            localQueue.add("test2.mp3");
        }
        return localQueue;
    }

    public void addToQueue(String songName) {
        if (!localQueue.contains(songName)) {
            localQueue.add(songName);
            System.out.println("Added to queue: " + songName);
        }
    }

    public void uploadSong(MultipartFile file) throws IOException {
        if (!s3Enabled) {
            System.out.println("S3 storage is disabled. File would have been saved: " + file.getOriginalFilename());
            // Add to local mock list
            addToMockSongs(file.getOriginalFilename());
            return;
        }
        
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            space.putObject(new PutObjectRequest("musicarchive1", file.getOriginalFilename(), file.getInputStream(), objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            System.out.println("File uploaded to S3: " + file.getOriginalFilename());
        } catch (Exception e) {
            System.out.println("Failed to upload file to S3: " + e.getMessage());
            // Add to local mock list as fallback
            addToMockSongs(file.getOriginalFilename());
        }
    }

    private void addToMockSongs(String fileName) {
        List<String> mockSongs = getMockSongs();
        if (!mockSongs.contains(fileName)) {
            mockSongs.add(fileName);
        }
    }
}