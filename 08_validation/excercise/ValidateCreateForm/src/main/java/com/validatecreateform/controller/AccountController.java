package com.validatecreateform.controller;

import com.validatecreateform.dto.AccountDto;
import com.validatecreateform.model.Account;
import com.validatecreateform.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/")
    public String showAllAccount(Model model){
        model.addAttribute("accountList", accountService.showAccount());
        return "index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("account", new AccountDto());
        return "create_account";
    }
    @PostMapping("/create")
    public String createAccount(@Valid @ModelAttribute(name = "account") AccountDto accountDto,
                                BindingResult bindingResult){
        new AccountDto().validate(accountDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "create_account";
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        accountService.createAccount(account);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id){
        model.addAttribute("account", accountService.getAccountById(id));
        return "edit_account";
    }
    @PostMapping("/edit/")
    public String editAccount(@Valid @ModelAttribute(name = "account") AccountDto accountDto,
                              BindingResult bindingResult){
        new AccountDto().validate(accountDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "edit_account";
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        accountService.updateAccount(account);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id){
        accountService.deleteAccountById(id);
        return "redirect:/";
    }
}
