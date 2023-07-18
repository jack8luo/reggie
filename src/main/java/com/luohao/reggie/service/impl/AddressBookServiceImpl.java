package com.luohao.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luohao.reggie.entity.AddressBook;
import com.luohao.reggie.mapper.AddressBookMapper;
import com.luohao.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author luo
 * @version 1.0
 * @description: TODO
 * @date 2023/7/18 12:14
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
