package org.ocl.controller;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.ocl.service.OclService;
import org.ocl.vo.OclValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class OclValidationController {
    private final OclService oclService;

    @Autowired
    public OclValidationController(OclService oclService) {
        this.oclService = oclService;
    }

    @PostMapping("/ocl/validate")
    @ResponseBody
    public ResponseEntity validate(@RequestParam("ocl") MultipartFile oclFile,
                                   @RequestParam("model") MultipartFile modelFile) {
        try(InputStream oclStream = oclFile.getInputStream();
            InputStream modelStream = modelFile.getInputStream()) {
            boolean result = oclService.validate(oclStream,
                    modelStream);
            return new ResponseEntity<>(new OclValidationResult(result), HttpStatus.OK);
        } catch (IOException | ParserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
