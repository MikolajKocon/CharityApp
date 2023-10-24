package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long count() {
        return donationRepository.count();
    }

    public Long sumBags() {
        return donationRepository.sumBags();
    }

    public void save(Donation donation){
        donationRepository.save(donation);
    }

}