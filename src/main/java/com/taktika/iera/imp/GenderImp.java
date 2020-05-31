package com.taktika.iera.imp;


import com.taktika.iera.dto.GenderDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.mapping.GenderMapping;
import com.taktika.iera.model.Gender;
import com.taktika.iera.repository.GenderRepository;
import com.taktika.iera.service.iGenderService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */
@Service
public class GenderImp implements iGenderService {

    @Autowired
    GenderMapping objGenderMapping;

    @Autowired
    GenderRepository objGenderRepository;

    @Override
    public GenderDto saveGender(GenderDto objGenderDto) throws Exception {
        Gender objGender;
        try {
            objGender = objGenderRepository.findByKind(objGenderDto.getKindDto());
            if (null == objGender) {
                objGender = new Gender();
                objGender.setKind(objGenderDto.getKindDto());
                objGenderDto = objGenderMapping.transformModelIntoDto(objGenderRepository.save(objGender));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objGenderDto;
    }

    @Override
    public boolean deleteGender(Long id) throws Exception {
        try {
            Gender objGender = objGenderMapping.transformOptionalIntoModel(objGenderRepository.findById(id));
            if (null == objGender){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }else {
                objGenderRepository.deleteById(id);
                return true;
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
    }

    @Override
    public Gender searchById(Long id) throws Exception {
        Gender objGender;
        try {
            objGender = objGenderMapping.transformOptionalIntoModel(objGenderRepository.findById(id));
            if (null == objGender){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objGender;
    }

    @Override
    public List<Gender> listGender() throws Exception {
        List<Gender> genderList;
        try {
            genderList = objGenderRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return genderList;
    }
}
