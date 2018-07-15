package kerktest

enum class Church(val n: String) {
    KATHOLIEK("Rooms-katholiek"),
    MODERN_GEREFORMEERD("Modern-gereformeerd"),
    ORTHODOX_GEREFORMEERD("Orthodox-gereformeerd"),
    BEVINDELIJK_GEREFORMEERD("Bevindelijk-gereformeerd"),
    VRIJZINNIG("Vrijzinnig"),
    CHARISMATISCH("Charismatisch evangelisch"),
    TRADITIONEEL_EVANGELISCH("Traditioneel evangelisch"),
    ALTERNATIEVE_STROMINGEN("Alternatieve stromingen")
}

fun getChurches() = Church.values().toList()
