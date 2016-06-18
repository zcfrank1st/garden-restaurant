package com.chaos.garden.dao.mapper.gen;

import com.chaos.garden.model.gen.Reserves;
import com.chaos.garden.model.gen.ReservesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int countByExample(ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int deleteByExample(ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int deleteByPrimaryKey(Integer reserveId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int insert(Reserves record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int insertSelective(Reserves record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    List<Reserves> selectByExampleWithBLOBs(ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    List<Reserves> selectByExample(ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    Reserves selectByPrimaryKey(Integer reserveId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") Reserves record, @Param("example") ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") Reserves record, @Param("example") ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByExample(@Param("record") Reserves record, @Param("example") ReservesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByPrimaryKeySelective(Reserves record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(Reserves record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reserves
     *
     * @mbggenerated Sat Jun 18 16:22:01 CST 2016
     */
    int updateByPrimaryKey(Reserves record);
}