package kerktest

import kerktest.Church.*

open class Answer(val text: String, val influence: List<Church> = emptyList(), var important: Int = 1)
data class Question(val question: String, val answers: List<Answer> = emptyList(), var selected: Answer? = null, val display: Boolean = true, var importance: Double = 1.0)

class MultipleChoice(text_: String, val answers: List<Answer> = emptyList()) : Answer(text_, emptyList())

fun getQuestions(): List<Question> =
        listOf(
                Question("Hoe denkt u over God?", listOf(
                        Answer("Er is één persoonlijke God, de Drie-eenheid van Vader, Zoon en Heilige Geest.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Er is één persoonlijke God, maar Hij is geen Drie-eenheid.", listOf(MODERN_GEREFORMEERD)),
                        Answer("Er is één God, die niet noodzakelijk persoonlijk is.", listOf(VRIJZINNIG)),
                        Answer("Geen mening.", listOf()))),
                Question("Hoe denkt u over de Bijbel?", listOf(
                        Answer("De Bijbel is het gezaghebbende Woord van God en op alle terreinen volledig betrouwbaar.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("De Bijbel is het Woord van God, maar hoeft niet altijd historisch betrouwbaar te zijn. ", listOf(MODERN_GEREFORMEERD)),
                        Answer("De Bijbel is een waardevol boek en een goede inspiratiebron, maar is puur mensenwerk.", listOf(VRIJZINNIG)),
                        Answer("Geen mening.", listOf()))),
                Question("Hoe denkt u over Jezus?", listOf(
                        Answer("Jezus was volkomen God en volkomen mens.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Jezus was meer dan een mens, maar niet God zelf.", listOf(MODERN_GEREFORMEERD)),
                        Answer("Jezus was een heel bijzonder mens.", listOf(VRIJZINNIG)),
                        Answer("Geen mening.", listOf()))),
                Question("Hoe denkt u over de opstanding van Jezus?", listOf(
                        Answer("Jezus is lichamelijk opgestaan uit de doden.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Het verhaal over Jezus' opstanding is symbolisch.", listOf(MODERN_GEREFORMEERD)),
                        Answer("Geen mening.", listOf()))),
                Question("Hoe wordt een mens gered?", listOf(
                        Answer("Een mens wordt, zonder dat hij daar enige bijdrage aan levert, gered uit genade alleen, als hij een waar geloof in Jezus Christus heeft.", listOf(ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD)),
                        Answer("God biedt aan iedereen zijn genade aan. Een mens wordt gered wanneer hij er uit vrije wil voor kiest om dit geschenk te aanvaarden en gelooft dat Jezus Christus voor zijn zonden gestorven is.", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("God komt een mens in zijn genade tegemoet zodat deze zelf in kan gaan op zijn uitnodiging. Een mens wordt gered door de sacramenten (in het bijzonder de doop) in geloof te ontvangen.", listOf(KATHOLIEK)),
                        Answer("Alle mensen komen in de hemel.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf()))),
                Question("Hoe weet een christen wat hij moet geloven en hoe hij moet handelen?", listOf(
                        Answer("Door te luisteren naar de kerkelijke traditie en de Bijbel.", listOf(KATHOLIEK)),
                        Answer("De Bijbel is hier de enige de norm voor, hoewel de gelovige de Bijbel alleen goed zal kunnen begrijpen als de Heilige Geest in hem werkt.", listOf(BEVINDELIJK_GEREFORMEERD, ORTHODOX_GEREFORMEERD, MODERN_GEREFORMEERD, TRADITIONEEL_EVANGELISCH)),
                        Answer("Niet alleen door de Bijbel, maar ook door profetie, visioenen en openbaringen.", listOf(CHARISMATISCH)),
                        Answer("Iedereen is er vrij in om dat te bepalen.", listOf(VRIJZINNIG)),
                        Answer("Geen mening.", listOf()))),
                Question("Waarop moet volgens u in een preek de grootste nadruk liggen?", listOf(
                        Answer("Hoe een mens bekeerd kan worden, om zo rechtvaardig te zijn voor God.", listOf(BEVINDELIJK_GEREFORMEERD)),
                        Answer("Hoe een mens tot eer van God kan leven.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Hoe een mens in liefde om kan zien naar zijn medemens.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over de Drie Formulieren van Enigheid (Heidelbergse Catechismus, Nederlandse Geloofsbelijdenis en Dordtse Leerregels)?", listOf(
                        Answer("Deze zijn gezaghebbend, omdat ze de boodschap van de Schrift vertolken.", listOf(BEVINDELIJK_GEREFORMEERD)),
                        Answer("Deze zijn een belangrijke inspiratiebron.", listOf(ORTHODOX_GEREFORMEERD)),
                        Answer("Deze spelen geen rol.", listOf(KATHOLIEK, MODERN_GEREFORMEERD, VRIJZINNIG, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over muziek in de kerk?", listOf(
                        Answer("Psalmen hebben sterk de voorkeur boven andere liederen omdat ze rechtstreeks uit de Bijbel komen. In de kerk worden dan ook liefst alleen psalmen (en 'enige gezangen') gezongen. ", listOf(BEVINDELIJK_GEREFORMEERD)),
                        Answer("In de kerk zouden vooral traditionele liederen gezongen moeten worden. Naast psalmen kunnen dit ook (klassieke) gezangen zijn. Voor modernere liederen is wel plaats, maar in beperkte mate.", listOf(KATHOLIEK, MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, VRIJZINNIG)),
                        Answer("De liedcultuur in de kerk moet goed aansluiten op de mens van vandaag. Dat kan het best wanneer de nadruk ligt op moderne liederen, bij voorkeur onder begeleiding van een worshipband.", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over de doop?", listOf(
                        Answer("Iemand mag pas gedoopt worden als hij/zij bewust gelooft.", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Ook de (kleine) kinderen van gelovigen dienen te worden gedoopt.", listOf(KATHOLIEK, MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over vrouwen in het ambt?", listOf(
                        Answer("Vrouwen mogen predikant/pastoor en ouderling/oudste worden.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Vrouwen behoren geen predikant/pastoor te worden, maar mogen wel ouderling/oudste zijn.", listOf(ORTHODOX_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Vrouwen behoren geen predikant/pastoor of ouderling/oudste te worden.", listOf(KATHOLIEK, BEVINDELIJK_GEREFORMEERD)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over de organisatie van de kerk?", listOf(
                        Answer("Lokale kerken moeten in grote mate zelfstandig zijn.", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("De kerk moet bestuurd worden door bisschoppen.", listOf(KATHOLIEK)),
                        Answer("De kerk moet bestuurd worden door kerkenraden en synodes.", listOf(MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("In welke mate moet traditie in de kerk een rol spelen?", listOf(
                        Answer("In grote mate.", listOf(KATHOLIEK)),
                        Answer("In enige mate.", listOf(MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, VRIJZINNIG)),
                        Answer("In zo klein mogelijke mate.", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over de aanwezigheid van Christus in avondmaal/eucharistie?", listOf(
                        Answer("Christus is lichamelijk aanwezig in het brood en de wijn.", listOf(KATHOLIEK)),
                        Answer("Christus is geestelijk aanwezig in het brood en de wijn.", listOf(MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD)),
                        Answer("Christus is geestelijk aanwezig in de gelovigen. Het brood en de wijn zijn puur symbolisch.", listOf(VRIJZINNIG, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over het deelnemen van kinderen aan avondmaal/eucharistie?", listOf(
                        Answer("Alleen volwassenen mogen (na zelfonderzoek) deelnemen.", listOf(ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD)),
                        Answer("Kinderen mogen deelnemen, maar pas vanaf een bepaalde leeftijd.", listOf(KATHOLIEK, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Kinderen mogen deelnemen vanaf het moment dat ze dat zelf willen.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over hemel en hel?", listOf(
                        Answer("Er bestaan een hemel en een hel.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Alleen de hemel bestaat, en iedereen zal hier naartoe gaan.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Alleen de hemel bestaat. Mensen die hier niet naartoe gaan, zullen worden vernietigd.", listOf(ALTERNATIEVE_STROMINGEN), 4),
                        Answer("Geen mening.", listOf())
                )),
                Question("Hoe denkt u over de rustdag?", listOf(
                        Answer("De rustdag is op zaterdag. Een christen behoort zich net als de joden te houden aan het vierde gebod: ‘Gedenk de sabbatdag, dat u die heiligt.’ ", listOf(ALTERNATIEVE_STROMINGEN), 4),
                        Answer("De rustdag is op zondag. Door op zondag niet te werken en zich meer dan op andere dagen op God te concentreren, neemt een christen het vierde gebod in acht: ‘Gedenk de sabbatdag, dat u die heiligt.’ ", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD)),
                        Answer("Een christen hoeft zich niet aan een rustdag te houden, maar het is wel een goed idee om een dag in de week uit te rusten.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG, CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Geen mening", listOf())
                )),
                Question("Hoe denkt u over bijzondere gaven van de Geest zoals profeteren, tongentaal en wonderbaarlijke genezingen?", listOf(
                        Answer("Deze gaven waren voornamelijk bedoeld voor de vroege kerk. Vandaag de dag komen ze (bijna) niet meer voor. ", listOf(KATHOLIEK, BEVINDELIJK_GEREFORMEERD)),
                        Answer("Deze gaven komen nog steeds voor, maar niet meer zo vaak als in de vroege kerk. ", listOf(MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, TRADITIONEEL_EVANGELISCH)),
                        Answer("Deze gaven zijn nog steeds beschikbaar en nastrevenswaardig voor alle christenen.", listOf(CHARISMATISCH)),
                        Answer("Deze gaven moeten symbolisch worden gezien.", listOf(VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Moet er in preken veel nadruk worden gelegd op persoonlijke bekering?", listOf(
                        Answer("Ja, want er gaan veel mensen naar de kerk die nog niet bekeerd zijn.", listOf(BEVINDELIJK_GEREFORMEERD)),
                        Answer("Ja, de kerk moet evangeliserende preken hebben die toegankelijk zijn voor niet-christenen. ", listOf(CHARISMATISCH, TRADITIONEEL_EVANGELISCH)),
                        Answer("Nee, dit is slechts een van de vele thema’s waar preken over zouden moeten gaan.", listOf(KATHOLIEK, MODERN_GEREFORMEERD, ORTHODOX_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Moet er in preken veel nadruk worden gelegd op de eindtijd?", listOf(
                        Answer("Ja, want de kans is groot dat de eindtijd nabij is.", listOf(CHARISMATISCH, ALTERNATIEVE_STROMINGEN), 4),
                        Answer("Nee, dit is slechts een van de vele thema’s waar preken over zouden moeten gaan.", listOf(KATHOLIEK, ORTHODOX_GEREFORMEERD, BEVINDELIJK_GEREFORMEERD, TRADITIONEEL_EVANGELISCH)),
                        Answer("Nee, ik geloof niet in de eindtijd.", listOf(MODERN_GEREFORMEERD, VRIJZINNIG)),
                        Answer("Geen mening.", listOf())
                )),
                Question("Ben je momenteel lid van een kerk?", listOf(
                        Answer("Nee", listOf()),
                        MultipleChoice("Ja: ", values().map { Answer("${it.n}") })
                ), display = false),
                Question("Welke stroming verwacht je dat de test je zal kwalificeren?",
                        listOf(MultipleChoice("", values().map { Answer(it.n) })
                ), display = false)
        )