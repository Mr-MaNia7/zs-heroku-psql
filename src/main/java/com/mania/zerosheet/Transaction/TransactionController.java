package com.mania.zerosheet.Transaction;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TransactionController {
    private final TransactionRepository transactionRepository;

    // from home to transactions
    @GetMapping("/transactions")
    public String showTransactions(Transaction transaction, Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        // System.out.println(transactionRepository.findAll());
        return "Transactions/view-transactions";
    }
    
    // from transactions to update-transaction
    @GetMapping("transactions/edittransaction/{transId}")
    public String showUpdateTransactionForm(@PathVariable ("transId") long transId, Model model) {
        Transaction transaction =
            transactionRepository
                .findById(transId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Transaction Id: " + transId));
        model.addAttribute("transaction", transaction);
        return "Transactions/update-transaction";
    }
    // from update-transaction (post and) redirect to transactions
    @PostMapping("/updatetransaction/{transId}")
    public String updateTransaction(@Valid Transaction transaction, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "Transactions/update-transaction";
        }
        transactionRepository.save(transaction);
        model.addAttribute("transactions", transactionRepository.findAll());
        return "redirect:/view-transactions";
    }
}
