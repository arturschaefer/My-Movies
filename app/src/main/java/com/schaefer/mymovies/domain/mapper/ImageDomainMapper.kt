package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Image
import com.schaefer.mymovies.domain.model.ImageDomain

class ImageDomainMapper : Mapper<Image, ImageDomain> {
    override fun map(source: Image): ImageDomain {
        return ImageDomain(
            medium = source.medium.orEmpty(),
            original = source.original.orEmpty()
        )
    }
}