package com.executor.service;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.executor.factory.ProgramExecutorFactory;
import com.reference.Language;


@Service
public class ExecutorService {

    public ResponseEntity<String> executorServiceSource(@RequestBody String requestData) {

        JSONObject requestJsonData = new JSONObject(requestData);

        // LANGUAGE TYPE
        Language requestLanguageType = Language.valueOf(requestJsonData.getString("languageType"));

        // SOURCE Data
        String requestInput = requestJsonData.getString("input");

        String output = "";
        switch (requestLanguageType) {
            case JAVA:
                output = ProgramExecutorFactory.getIExecutor(Language.JAVA)
                        .entryClass(requestJsonData.getString("class"))
                        .execute(requestInput);
                break;
            case PYTHON:
                output = ProgramExecutorFactory.getIExecutor(Language.PYTHON).execute(requestInput);
                break;
            case C:

                break;
            default:
                output = "- Wrong request -";
        }

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
