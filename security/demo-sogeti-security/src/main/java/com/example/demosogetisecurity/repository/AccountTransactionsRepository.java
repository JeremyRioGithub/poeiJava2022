package com.example.demosogetisecurity.repository;

import com.example.demosogetisecurity.model.AccountTransactions;
import com.example.demosogetisecurity.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountTransactionsRepository extends CrudRepository<Accounts, Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
