package edu.ijse.cw2.service.custom.impl;

import java.util.ArrayList;

import edu.ijse.cw2.dao.DaoFactory;
import edu.ijse.cw2.dao.custom.MemberDao;
import edu.ijse.cw2.dto.MemberDto;
import edu.ijse.cw2.entity.MemberEntity;
import edu.ijse.cw2.service.custom.MemberService;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao =(MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

    @Override
    public String save(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.create(memberEntity)?"Success":"Fail";
    }

    @Override
    public String update(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.update(memberEntity)?"Success":"Fail";
        
    }

    @Override
    public String delete(String memberId) throws Exception {
        return memberDao.delete(memberId)?"Success":"Fail";
    }

    @Override
    public MemberDto get(String memberId) throws Exception {
        MemberEntity memberEntity =memberDao.get(memberId);
        if (memberEntity!=null) {
            return getMemberDto(memberEntity);
        }
         return null;
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntities = memberDao.getAll();
        if (memberEntities!=null && !memberEntities.isEmpty()) {
            ArrayList<MemberDto> memberDtos =new ArrayList<>();

            for (MemberEntity memberEntitys : memberEntities) {
                memberDtos.add(getMemberDto(memberEntitys));
            }
            return memberDtos;
        }
        return null;
    }


    private MemberEntity getMemberEntity(MemberDto memberDto){
        return new MemberEntity(memberDto.getMemberId(), memberDto.getMemberName(), memberDto.getMemberEmail(), memberDto.getMemberPhone(), memberDto.getMemberAddress());
    }
    private MemberDto getMemberDto(MemberEntity memberEntity){
        return new MemberDto(memberEntity.getMemberId(), memberEntity.getMemberName(), memberEntity.getMemberEmail(), memberEntity.getMemberPhone(), memberEntity.getMemberAddress());
    }
    
}
