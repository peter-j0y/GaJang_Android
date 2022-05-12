package com.minrd.gajang.data.model

data class ResponseNecessariesData(
    // 비고
    val ADD_COL: String?,
    // 품목 이름
    val A_NAME: String?,
    // 가격
    val A_PRICE: String?,
    // 품목 번호
    val A_SEQ: String?,
    // 실판매 규격
    val A_UNIT: String?,
    // 자치구 코드
    val M_GU_CODE: String?,
    // 자치구 이름
    val M_GU_NAME: String?,
    // 시장, 마트 이름
    val M_NAME: String?,
    // 시장, 마트 번호
    val M_SEQ: String?,
    // 시장 유형 구분 코드
    val M_TYPE_CODE: String?,
    // 시장 유형 구분 이름
    val M_TYPE_NAME: String?,
    // 점검일자
    val P_DATE: String?,
    // 일련번호
    val P_SEQ: String?,
    // 년도-월
    val P_YEAR_MONTH: String?
)