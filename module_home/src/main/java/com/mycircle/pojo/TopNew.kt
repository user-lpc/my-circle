package com.mycircle.pojo

data class TopNew (val DataStatus:DataStatus,val Data:List<Data>)

data class DataStatus(val RequestParameter:String,val StatusCode:Int,val StatusDescription:String)
data class Data(val ArticleId:String,val ArticleTitle:String)