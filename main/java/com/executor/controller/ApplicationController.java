package com.executor.controller;

import com.executor.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ApplicationController {

    @Autowired
    private ExecutorService executorService;

    @RequestMapping(path = "/sourceExecutor", method = RequestMethod.POST)
    public ResponseEntity<String> executorServiceSource(@RequestBody String requestData) throws IOException {
        ResponseEntity<String> temp = this.executorService.executorServiceSource(requestData);
        return temp;
    }
}