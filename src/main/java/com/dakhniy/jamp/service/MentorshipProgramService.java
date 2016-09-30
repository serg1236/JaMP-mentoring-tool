package com.dakhniy.jamp.service;

import com.dakhniy.jamp.exception.ItemExistsException;
import com.dakhniy.jamp.model.MentorshipProgram;
import com.dakhniy.jamp.repository.MentorshipProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sergiy_Dakhniy on 9/29/2016.
 */
@Service
public class MentorshipProgramService {

    @Autowired
    private MentorshipProgramRepository mentorshipProgramRepository;

    public MentorshipProgram createProgram(MentorshipProgram mentorshipProgram) {
        if(mentorshipProgram.getId() != null && mentorshipProgramRepository.exists(mentorshipProgram.getId())) {
            throw new ItemExistsException();
        } else {
            return mentorshipProgramRepository.save(mentorshipProgram);
        }
    }

    public List<MentorshipProgram> getPrograms() {
        return mentorshipProgramRepository.findAll();
    }

    public MentorshipProgram updateProgram(MentorshipProgram mentorshipProgram) {
        return mentorshipProgramRepository.save(mentorshipProgram);
    }

    public void deleteProgram(Long id) {
        mentorshipProgramRepository.delete(id);
    }
}
