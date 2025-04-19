package com.example.demo.controllers;

import com.example.demo.models.Text;
import com.example.demo.models.Video;
import com.example.demo.models.File;
import com.example.demo.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService<Text> textService;
    private final ResourceService<Video> videoService;
    private final ResourceService<File> fileService;

    // TEXT endpoints
    @GetMapping("/texts")
    public List<Text> getAllTexts() {
        return textService.findAll();
    }

    @PostMapping("/texts")
    public ResponseEntity<Text> createText(@RequestBody Text text) {
        return ResponseEntity.ok(textService.save(text));
    }

    @DeleteMapping("/texts/{id}")
    public ResponseEntity<Void> deleteText(@PathVariable Long id) {
        textService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // VIDEO endpoints
    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoService.findAll();
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.save(video));
    }

    @DeleteMapping("/videos/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // FILE endpoints
    @GetMapping("/files")
    public List<File> getAllFiles() {
        return fileService.findAll();
    }

    @PostMapping("/files")
    public ResponseEntity<File> createFile(@RequestBody File file) {
        return ResponseEntity.ok(fileService.save(file));
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        fileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
