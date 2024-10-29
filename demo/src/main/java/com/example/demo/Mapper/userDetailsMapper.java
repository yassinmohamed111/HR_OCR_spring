package com.example.demo.Mapper;

import com.example.demo.DTO.EducationDto;
import com.example.demo.DTO.ExperienceDto;
import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.Model.Education;
import com.example.demo.Model.Experience;
import com.example.demo.Model.user_details;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class userDetailsMapper {

    public user_details mapperToEntity(UserDetailsRequestDTO userDetailsRequestDTO) {
        user_details user_details = new user_details();
        List<Education> educationList = new ArrayList<>();
        List<Experience> experienceList = new ArrayList<>();

        user_details.setAddress(userDetailsRequestDTO.getAddress());
        user_details.setDob(userDetailsRequestDTO.getDob());
        user_details.setGender(userDetailsRequestDTO.getGender());
        user_details.setMartial_status(userDetailsRequestDTO.getMartial_status());
        user_details.setPhone(userDetailsRequestDTO.getPhone());
        user_details.setName(userDetailsRequestDTO.getName());
        user_details.setPob(userDetailsRequestDTO.getPob());
        user_details.setMilitary_status(userDetailsRequestDTO.getMilitary_status());
        user_details.setSSN(userDetailsRequestDTO.getSSN());

        for(EducationDto educationDto : userDetailsRequestDTO.getEducations()) {
            Education education = new Education();

            education.setGrade(educationDto.getGrade());
            education.setDate(educationDto.getDate());
            education.setUser_details(user_details);
            education.setMajor(educationDto.getMajor());
            education.setUniversity(educationDto.getUniversity());
            education.setDegree(educationDto.getDegree());
            educationList.add(education);

        }

        for(ExperienceDto experienceDto : userDetailsRequestDTO.getExperiences()) {
            Experience experience = new Experience();

            experience.setCompany_name(experienceDto.getCompany_name());
            experience.setReason(experienceDto.getReason());
            experience.setUser_details(user_details);
            experience.setPostion(experienceDto.getPostion());
            experience.setEnd_date(experienceDto.getEnd_date());
            experience.setStart_date(experienceDto.getStart_date());
            experienceList.add(experience);

        }
        user_details.setEducations(educationList);
        user_details.setExperiences(experienceList);
        return user_details;
    }
}
