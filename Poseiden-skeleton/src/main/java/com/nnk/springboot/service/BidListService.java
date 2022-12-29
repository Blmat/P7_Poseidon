package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.exception.BidServiceException;

public interface BidListService {
    boolean createBid(BidList bidEntity) throws BidServiceException;

    void validate(BidList bidList);

    boolean updateBid(Integer id, BidList bidEntityUpdated) throws BidServiceException;

    boolean deleteBid(Integer id) throws BidServiceException;


}
