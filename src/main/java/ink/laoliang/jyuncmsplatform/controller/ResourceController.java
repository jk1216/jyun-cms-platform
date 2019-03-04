package ink.laoliang.jyuncmsplatform.controller;

import ink.laoliang.jyuncmsplatform.domain.Resource;
import ink.laoliang.jyuncmsplatform.domain.response.FilterConditions;
import ink.laoliang.jyuncmsplatform.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getResources() {
        return resourceService.getResources();
    }

    @PostMapping
    public Resource upload(@RequestParam MultipartFile file) {
        return resourceService.upload(file);
    }

    @DeleteMapping
    public List<Resource> deleteResource(@RequestParam String filePath) {
        return resourceService.deleteResource(filePath);
    }

    @GetMapping(value = "/filter-conditions")
    public FilterConditions getFilterConditions() {
        return resourceService.getFilterConditions();
    }

    @GetMapping(value = "/by-conditions")
    public List<Resource> getByConditions(@RequestParam String date,
                                          @RequestParam String type) {
        return resourceService.getByConditions(date, type);
    }
}
