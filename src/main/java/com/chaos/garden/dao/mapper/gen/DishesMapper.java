package com.chaos.garden.dao.mapper.gen;

import com.chaos.garden.model.gen.Dishes;
import com.chaos.garden.model.gen.DishesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int countByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int deleteByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int deleteByPrimaryKey(Integer dishId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int insert(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int insertSelective(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    List<Dishes> selectByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    Dishes selectByPrimaryKey(Integer dishId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") Dishes record, @Param("example") DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByExample(@Param("record") Dishes record, @Param("example") DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByPrimaryKeySelective(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dishes
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByPrimaryKey(Dishes record);
}