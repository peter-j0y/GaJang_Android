package com.example.gajang.data.model

data class ResponseNecessariesData(
    val ListNecessariesPricesService: ListNecessariesPrices
){
    data class ListNecessariesPrices(
        val RESULT: Result,
        val list_total_count: Int,
        val row: ArrayList<Row>
    )
    data class Row(
        // 비고
        val ADD_COL: String,
        // 품목 이름
        val A_NAME: String,
        // 가격
        val A_PRICE: String,
        // 품목 번호
        val A_SEQ: Double,
        // 실판매 규격
        val A_UNIT: String,
        // 자치구 코드
        val M_GU_CODE: String,
        // 자치구 이름
        val M_GU_NAME: String,
        // 시장, 마트 이름
        val M_NAME: String,
        // 시장, 마트 번호
        val M_SEQ: Double,
        // 시장 유형 구분 코드
        val M_TYPE_CODE: String,
        // 시장 유형 구분 이름
        val M_TYPE_NAME: String,
        // 점검일자
        val P_DATE: String,
        // 일련번호
        val P_SEQ: Double,
        // 년도-월
        val P_YEAR_MONTH: String
    )
    data class Result(
        val CODE: String,
        val MESSAGE: String
    )
}