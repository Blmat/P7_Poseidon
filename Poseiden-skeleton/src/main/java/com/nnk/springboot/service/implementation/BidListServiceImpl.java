package com.nnk.springboot.service.implementation;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.exception.BidServiceException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BidListServiceImpl implements BidListService {

    //UserStory2
    private final BidListRepository bidListRepository;


    /**
     * Create a Bid
     *
     * @param bidEntity The Bid Entity to create
     * @return True if the creation was successful
     */
    @Override
    public  boolean createBid(BidList bidEntity) throws BidServiceException {
        if (bidEntity != null && !bidListRepository.findBidListById(bidEntity.getId()).isPresent()) {
            log.info("[BID SERVICE] Created new bid for account : '{}', quantity : '{}'", bidEntity.getAccount(),
                    bidEntity.getBidQuantity());
             bidListRepository.save(bidEntity);
            return true;
        }
        throw new BidServiceException("There was an error while creating the Bid");
    }

    /**
     * Update an existing Bid
     *
     * @param id The Bid ID to update
     * @param bidEntityUpdated The new fields given for update
     * @return True if the update was successful
     */
    @Override
    public boolean updateBid(Integer id, BidList bidEntityUpdated) throws BidServiceException {
        Optional<BidList> bidList = bidListRepository.findBidListById(id);
        if (id != null && bidList.isPresent()) {

            bidEntityUpdated.setId(id);
            bidListRepository.save(bidEntityUpdated);

            log.info("[BID SERVICE] Updated account '{}' with id '{}'", bidEntityUpdated.getAccount(), id);
            return true;
        }
        throw new BidServiceException("Could not find bid with id : " + id);
    }

    /**
     * Delete a Bid
     *
     * @param id l'ID du BID à effacer
     * @return True si la suppression à bien fonctionné
     * @throws BidServiceException Thrown si l'id n'a pas été trouvé.
     */
    @Override
    public boolean deleteBid(Integer id) throws BidServiceException {
        Optional<BidList> bid = bidListRepository.findBidListById(id);
        if (id != null && bid.isPresent()) {
            bidListRepository.delete(bid.get());
            log.info("[BID SERVICE] Deleted bid with id '{}'", id);
            return true;
        }
        throw new BidServiceException("Could not find bid with id : " + id);
    }
}
