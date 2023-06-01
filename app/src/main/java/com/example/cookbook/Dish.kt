package com.example.cookbook

class Dish private constructor(val tmpId: Int, val name: String, val recipe: String, val time: Int,
                               val imageResourceId: Int) {

    override fun toString(): String {
        return name
    }

    companion object {

        fun getCategories() {
            val resultListOther: MutableList<Dish> = arrayListOf()
            val resultListSandwiches: MutableList<Dish> = arrayListOf()
            for(element in dishes){
                if (!element.name.contains("kanapk", ignoreCase = true)) resultListOther.add(element)
                else resultListSandwiches.add(element)
            }
            other =  resultListOther.toTypedArray()
            sandwiches = resultListSandwiches.toTypedArray()
        }

        var sandwiches = arrayOf<Dish>()
        var other = arrayOf<Dish>()
        val dishes = arrayOf(
            Dish(0, "Jajecznica", "Na patelni rozpuszczamy masło. Opcjonalnie można tutaj podsmażyć szynkę/boczek oraz cebulkę dla smaku.\n\nWlewamy jajka, doprawiamy i cały czas mieszamy. \n\n" +
                    "Kiedy jajka się zetną, przekładamy jajecznicę do miseczki. \n\nDekorujemy listkami bazylii", 11*60, R.drawable.jajecznica),
            Dish(1, "Płatki z mlekiem", "Do miski wsyp zadowalającą ilość płatków.\n\nDo miski dolej mleka wg uznania", 3*60, R.drawable.platki_na_mleku),
            Dish(2, "Kanapki z pesto, kurczakiem i mozarellą", "Bułkę przekrój na pół, jedną kromkę posmaruj masłem, a drugą bazyliowym pesto. \n\n" +
                    "Na wierzch połóż suszone pomidory, wędzoną pierś kurczaka i mozarelle wg uznania\n\n" +
                    "Jeśli istnieje możliwość, to koniecznie podgrzej kanapkę. Dzięki temu ser się roztopi i będzie się przyjemnie ciągnął.", 5*60, R.drawable.kanapki),
            Dish(3, "Tosty (kanapki)", "Chleb posmaruj masłem, na 2 kromkach połóż ser, szynkę, ogórka, pomidora, przykryj pozostałymi kromkami. \n\n" +
                    "Kanapki włóż do opiekacza na kilka minut, aż chleb się zarumieni. \n\n" +
                    "Gotowe tosty przekrój na trójkąty, podawaj z kiełkami rzeżuchy i ketchupem", 8*60, R.drawable.generic_meal),
            Dish(4, "Szakszuka", "*Krok 1*\n\n" +
                    "Sparz pomidory. W tym celu wytnij z nich szypułkę, a spód warzywa delikatnie natnij na krzyż. Pomidory umieść na ok. 10 sekund we wrzątk" +
                    "u, a następnie w zimnej wodzie. Usuń skórkę, która powinna już ładnie odchodzić i przekrój je na pół. " +
                    "Pozostały miąższ pomidorowy pokrój w kosteczkę. W taką samą kosteczkę na desce do krojenia pokrój cebulę dymkę i paprykę. Przygotuj też poz" +
                    "ostałe składniki – posiekaj szczypior, czosnek, chili i kolendrę." +
                    "\n\n\n*Krok 2*\n\n" +
                    "Na teflonowej patelni rozgrzej oliwę i podsmaż czosnek. Kiedy lekko się zarumieni, dodaj papryczkę chili, cebulę i paprykę, " +
                    "a następnie posyp całość Przyprawą do warzyw z grilla Knorr. Smaż wszystko razem dłuższą chwilę. W kolejnym etapie dodaj pomidory, " +
                    "kolendrę, słodką paprykę, szczypior i kmin rzymski. Wszystko razem dokładnie wymieszaj i podsmażaj kilka dodatkowych minut, żeby smaki" +
                    " się połączyły. Na koniec dopraw danie szakszuka szczyptą soli." +
                    "\n\n\n*Krok 2*\n\n" +
                    "Szakszuka jest już prawie gotowa. Podsmażone składniki rozłóż do małych naczynek żaroodpornych. " +
                    "Do każdego naczynia wbij kurze jajko. Miseczki wstaw do nagrzanego do 160°C piekarnika na ok. 10 minut. Gotowe!\n\n",25*60, R.drawable.szakszuka),
            Dish(5, "Kanapki z pastą rybną z jajkiem i ogórkiem konserwowym",
                "Krok 1\n\n" +
                        "Jaja ugotuj na twardo obierz zetrzyj na drobnej tarce, ogórki pokrój w kosteczkę lub też zetrzyj " +
                        "na tarce na grubych oczkach, drobno pokrój szczypior. Pestki słonecznika upraż na patelni." +
                        "\n\n\nKrok 2\n\n" +
                        "Makrelę oczyść ze skóry i ości , przełóż do miski dodaj majonez, wyciśnij trochę soku z połówki cytryny" +
                        ". Makrelę ugnieć na pastę dodaj jajka ogórka szczypior, pestki słonecznika, dokładnie wymieszaj. Pastę dopra" +
                        "w do smaku papryką i o ile zachodzi taka potrzeba szczyptą soli." +
                        "\n\n\nKrok 3\n\n" +
                        "Pastę z makreli podawaj z chlebem razowym.", 5*60, R.drawable.kanapki),
            Dish(6, "Omlet z kurczakiem i brokułami", "Krok 1\n\n" +
                    "Rozbij jaja i rozmieszaj je na jednolitą masę." +
                    "\n\n\nKrok 2\n\n" +
                    "Umyj kurczaka, pokrój go w paski. Następnie przesmaż na oliwie z oliwek." +
                    "\n\n\nKrok 3\n\n" +
                    "Podziel brokuł na małe różyczki i ugotuj w osolonej wodzie." +
                    "\n\n\nKrok 4\n\n" +
                    "Rozpuść masło na rozgrzanej patelni, po czym wlej jaja, dodaj kurczaka oraz brokuły" +
                    ". Należy uważać, aby masło nie przypaliło się, inaczej potrawa będzie niezdrowa i niesma" +
                    "czna. Smaż całość do momentu, kiedy jaja zaczną się ścinać. " +
                    "\n\n\nKrok 5\n\n" +
                    "Posyp omlet z wierzchu Przyprawą do kurczaka Knorr i podawaj.", 15*60, R.drawable.generic_meal),
            Dish(7, "Włoskie panini z szynką i serem (Kanapki)", "Krok 1\n" +
                    "\n" +
                    "Oliwę wlej do kielicha blendera. Dodaj suszone pomidory, kilka listków bazylii i kostkę bulionu warzywnego Knorr. Całość zmiksuj na gęstą pastę.\n" +
                    "Włoskie panini z szynką i serem\n\n\n" +
                    "Krok 2\n" +
                    "\n" +
                    "Chleb panini przekrój wzdłuż na dwie równe połowy. Obie części posmaruj wcześniej przygotowaną pastą z kostki Knorr.\n" +
                    "Włoskie panini z szynką i serem \n\n\n" +
                    "Krok 3\n" +
                    "\n" +
                    "Przygotuj deskę do krojenia. Pomidory umyj i osusz, a następnie pokrój w plasterki. Oliwki pokrój na równe krążki.\n" +
                    "Włoskie panini z szynką i serem \n\n\n" +
                    "Krok 4\n" +
                    "\n" +
                    "Na posmarowaną pastą kromkę pieczywa panini połóż dwa plastry sera żółtego, plaster ulubionej szynki, pomidora oraz oliwki. Przykryj drugą kromką.\n" +
                    "Włoskie panini z szynką i serem \n\n\n" +
                    "Krok 5\n" +
                    "\n" +
                    "Gotowe panini z szynką i serem połóż na ruszt grilla elektrycznego, zamknij pokrywę i grilluj z obu stron, aby chleb zrobił się chrupiący, a ser wewnątrz dobrze się rozpuścił.\n" +
                    "Włoskie panini z szynką i serem \n\n\n" +
                    "Krok 6\n" +
                    "\n" +
                    "Rukolę wymieszaj z oliwą. Gotowe panini z szynką i serem przekrój na pół i podawaj z sałatką.\n", 30*60, R.drawable.kanapki),
            Dish(8, "Placuszki z cynamonem", "Krok 1\n\n" +
                    "Do miseczki wbij kurze jajka, dodaj mleko oraz wodę, a następnie rozbij składniki za pomocą trzepaczki lub kuchennego mieszadła, do momentu dokładnego połączenia się.\n" +
                    "Placuszki z cynamonem \n\n\nKrok 2\n\n" +
                    "Do jajecznej mikstury dodaj mąkę macę i dokładnie wymieszaj, żeby nie było grudek. Dopraw do smaku solą i cukrem.\n\n\n" +
                    "Krok 3\n\n" +
                    "Na patelni rozgrzej olej, nakładaj łyżką porcje ciasta i smaż na złoty kolor. Placuszki z cynamonu wykładaj na talerz wyłożony ręcznikiem papierowym – w" +
                    " ten sposób pozbędziesz się z nich nadmiaru tłuszczu. Placki cynamonowe podawaj posypane cukrem pudrem i cynamonem.", 15*60, R.drawable.placki_cynamonowe),
            Dish(9, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(10, "Genreic (Kanapki)", "Generic", 10*60, R.drawable.generic_meal),
            Dish(11, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(12, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(13, "Genreic (Kanapki)", "Generic", 10*60, R.drawable.generic_meal),
            Dish(14, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(15, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(16, "Genreic", "Generic", 10*60, R.drawable.generic_meal),
            Dish(17, "Genreic (Kanapki)", "Generic", 10*60, R.drawable.generic_meal)
        )
    }
}