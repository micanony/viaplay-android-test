package se.micanonym.viaplaysample.utils

import se.micanonym.viaplaysample.data.ViaplayApi
import se.micanonym.viaplaysample.data.models.Section

object SectionUtils {
    fun getName(section: Section) = section.href
        .replace(ViaplayApi.BASE_URL, "")
        .replace(ViaplayApi.SECTIONS_BASE_URL, "")
        .replace("/", "")
        .replace("{?dtg}", "")
}
