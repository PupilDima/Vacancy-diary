package com.vacancydiary.mapper;

import com.vacancydiary.entity.RecruiterContact;
import com.vacancydiary.entity.dto.RecruiterContactDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RecruiterContactMapper {

    //    static RecruiterContact map(RecruiterContactDto recruiterContactDto) {
//        return new RecruiterContact(recruiterContactDto.getEmail(), recruiterContactDto.getPhone());
//    }
    RecruiterContact map(RecruiterContactDto recruiterContactDto);

    RecruiterContactDto map(RecruiterContact recruiterContact);
}
