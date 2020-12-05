package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ImageData
import com.schaefer.mymovies.domain.model.ImageDomain

class ImageDomainMapper : Mapper<ImageData, ImageDomain> {
    override fun map(source: ImageData): ImageDomain {
        return ImageDomain(
            medium = source.medium,
            original = source.original
        )
    }
}