package com.tree.gdhealth.branch.api;

import com.tree.gdhealth.vo.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchApiMapper {

    Branch getBranchOne(int branchNo);
}