package com.thutasann.shopping_cart.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import com.thutasann.shopping_cart.dto.ImageDto;
import com.thutasann.shopping_cart.model.Image;
import com.thutasann.shopping_cart.response.ApiResponse;
import com.thutasann.shopping_cart.service.image.IImageService;

import io.swagger.v3.oas.annotations.Operation;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/images")
@RequiredArgsConstructor
public class ImageController {
    private final IImageService imageService;

    @GetMapping("/test")
    @Operation(summary = "Image Endpoint Test", description = "This is the image endpoint test")
    public ResponseEntity<ApiResponse> imgTest() {
        return ResponseEntity.ok(new ApiResponse("Hello imgTest", "Hello test"));
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> saveImages(@RequestParam List<MultipartFile> files,
            @RequestParam Long productId) {
        try {
            List<ImageDto> imageDtos = imageService.saveImages(productId, files);
            return ResponseEntity.ok(new ApiResponse("Upload success", imageDtos));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Upload failed!", e.getMessage()));
        }
    }

    @GetMapping("/image/download/{imageId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable Long imageId) throws SQLException {
        Image image = imageService.getImageById(imageId);
        ByteArrayResource resource = new ByteArrayResource(
                image.getImage().getBytes(1, (int) image.getImage().length()));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")
                .body(resource);
    }

}
