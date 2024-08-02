package edu.ijse.cw2.service.custom;

import java.util.ArrayList;

import edu.ijse.cw2.dto.MemberDto;
import edu.ijse.cw2.service.SuperService;

public interface MemberService extends SuperService{
    String save(MemberDto memberDto)throws Exception;
    String update(MemberDto memberDto)throws Exception;
    String delete(String memberId)throws Exception;
    MemberDto get(String memberId)throws Exception;
    ArrayList<MemberDto> getAll()throws Exception;
}
