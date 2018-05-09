package com.mll.data.testing.acct.service;

import com.mll.data.testing.acct.entity.Merchant;

public interface MerchantService {
    void saveMerchant(Merchant merchant);

    Merchant findMerchantByUserId(String userId);
}
