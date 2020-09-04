package com.tb.task.models.responses

import com.tb.task.models.entities.TBClass

class ClassResponse {
    lateinit var data: Data

    class Data {
        lateinit var classes: ArrayList<TBClass>
    }
}