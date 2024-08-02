package edu.ijse.cw2.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.ijse.cw2.dao.CrudUtil;
import edu.ijse.cw2.dao.custom.MemberDao;
import edu.ijse.cw2.entity.MemberEntity;

public class MemberDaoImpl implements MemberDao{

    @Override
    public boolean create(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Member Values(?,?,?,?,?)", t.getMemberId(),t.getMemberName(),t.getMemberEmail(),t.getMemberPhone(),t.getMemberAddress());
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE Member SET Name=?,Email=?,Phone=?,Address=? WHERE MemberID = ? ", t.getMemberName(),t.getMemberEmail(),t.getMemberPhone(),t.getMemberAddress(),t.getMemberId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Member WHERE MemberID = ?", id);
    }

    @Override
    public MemberEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member WHERE MemberID = ?", id);
        if (rst.next()) {
            MemberEntity entity = new MemberEntity(rst.getString("MemberID"), rst.getString("Name"), rst.getString("Email"), rst.getString("Phone"), rst.getString("Address"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntities =new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member");

        while (rst.next()) {
            MemberEntity entity = new MemberEntity(rst.getString("MemberID"), rst.getString("Name"), rst.getString("Email"), rst.getString("Phone"), rst.getString("Address"));
            memberEntities.add(entity);
        }
        return memberEntities;
    }
    
}
