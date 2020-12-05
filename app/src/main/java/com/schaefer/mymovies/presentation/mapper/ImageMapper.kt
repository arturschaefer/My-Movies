package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ImageData
import com.schaefer.mymovies.domain.model.ImageDomain
import com.schaefer.mymovies.presentation.model.Image

class ImageMapper : Mapper<ImageDomain, Image> {
    override fun map(source: ImageDomain): Image {
        return Image(
            medium = source.medium,
            original = source.original
        )
    }
}