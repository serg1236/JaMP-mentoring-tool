package com.dakhniy.jamp.controller;

import com.dakhniy.jamp.model.MentorshipProgram;
import com.dakhniy.jamp.service.MentorshipProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by Sergiy_Dakhniy on 9/29/2016.
 */
@Controller
@RequestMapping("/programs")
public class MentorshipProgramController {

    @Autowired
    private MentorshipProgramService mentorshipProgramService;

    @PostMapping
    @ResponseBody
    public MentorshipProgram createProgram(@RequestBody @Valid MentorshipProgram program) {
        return mentorshipProgramService.createProgram(program);

    }

    @GetMapping
    @ResponseBody
    public List<MentorshipProgram> getPrograms() {
        return mentorshipProgramService.getPrograms();
    }

    @PutMapping
    @ResponseBody
    public MentorshipProgram updateProgram(@RequestBody @Valid MentorshipProgram program) {
        return mentorshipProgramService.updateProgram(program);
    }

    @DeleteMapping
    @ResponseBody
    @RequestMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        mentorshipProgramService.deleteProgram(id);
        return ResponseEntity.ok().body(null);
    }

}
