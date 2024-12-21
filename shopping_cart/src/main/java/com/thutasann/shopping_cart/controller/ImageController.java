package com.thutasann.shopping_cart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thutasann.shopping_cart.dto.ImageDto;
import com.thutasann.shopping_cart.response.ApiResponse;
import com.thutasann.shopping_cart.service.image.IImageService;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/images")
@RequiredArgsConstructor
public class ImageController {
    private final IImageService imageService;

    @GetMapping("/test")
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
}
