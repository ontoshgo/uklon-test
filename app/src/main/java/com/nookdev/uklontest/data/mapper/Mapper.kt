package com.nookdev.uklontest.data.mapper

interface Mapper<Input, Output> {
    fun map(input: Input): Output
    fun mapAll(list: List<Input>): List<Output> = list.map { map(it) }
    fun reverse(output: Output): Input
    fun reverseAll(list: List<Output>): List<Input> = list.map { reverse(it) }
}