package com.lyf.mybatisplusstudy.sys.mapper;

import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyf.mybatisplusstudy.sys.model.MyPage;
import com.lyf.mybatisplusstudy.sys.model.ParamSome;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-10-25
 */
public interface PersonMapper extends BaseMapper<Person> {

    /**
     * 3.x 的 page 可以进行取值,多个入参记得加上注解
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     * todo 目前使用注解会报错,写在 xml 里就没事
     *
     * @param myPage 自定义 page
     * @return 分页数据
     */
    MyPage<Person> mySelectPage(@Param("pg") MyPage<Person> myPage, @Param("ps") ParamSome paramSome);

    MyPage<Person>myselectpage(@Param(("pg"))MyPage<Person> myPage);


}
