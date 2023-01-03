package com.example.demosogetisecurity.repository;

import com.example.demosogetisecurity.model.AccountTransactions;
import com.example.demosogetisecurity.model.Accounts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTransactionsRepository extends CrudRepository<Accounts, Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
