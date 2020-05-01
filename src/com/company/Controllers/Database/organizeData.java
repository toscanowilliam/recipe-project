package com.company.Controllers.Database;

import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class organizeData
{
    public static List<String> listOfNamesOfAllRecipes (List<Recipe> listOfExistingRecipes)
    {
        List<String> listOfNamesOfExistingRecipes = new ArrayList<>();

        for (Recipe recipe: listOfExistingRecipes)
        {
            String name = recipe.getNameOfRecipe();
            listOfNamesOfExistingRecipes.add(name);
        }
        return listOfNamesOfExistingRecipes;
    }

    public static List<List<String>> sounds()
    {


        List<List<String>> listOfSounds = new ArrayList<>();

        List<String> i0 = new ArrayList<>();
        i0.add("e");
        i0.add("ee");
        i0.add("ea");
        i0.add("ie");
        i0.add("ei");
        listOfSounds.add(i0);
        /*Substrings:   e, ee, ea ,ie, ei

          Examples:     be, eve, see, meet, sleep, meal, read, leave, sea, team, field, believe, receive

          Exceptions:   been [i];
                        bread, deaf [e];
                        great, break [ei];
                        friend [e]

          Possible formula: constant  + sound + constant or white space
        */

        List<String> i = new ArrayList<>();
        i.add("i");
        i.add("y");
        listOfSounds.add(i);


        /*Substrings:   i, y

          Examples:     it, kiss, tip, pick, dinner, system, busy, pity, sunny

          Exceptions:   machine, ski, liter, pizza [i:]

          Possible formula: constant/whitespace + sound + constant/whitespace

        */

        List<String> e = new ArrayList<>();
        e.add("e");
        e.add("ea");
        listOfSounds.add(e);


        /*Substrings:   e, ea

          Examples:     let, tell, press, send, end, bread, dead, weather, leather

          Exceptions:   meter [i:]
                        sea, mean [i:]

          Possible Formula: constant + sound + constant

        */

        List<String> ei = new ArrayList<>();
        ei.add("a");
        ei.add("ai");
        ei.add("ay");
        ei.add("ei");
        ei.add("ey");
        ei.add("ea");
        listOfSounds.add(ei);

        /*Substrings:   a, ai, ay, ei, ey, ea

          Examples:     late, make, race, able, stable, aim, wait, play, say, day,
                        eight, weight, they, hey, break, great, steak

          Exceptions:   said, says [e];
                        height, eye [ai]

          Possible Formula: constant + sound + constant

        */

        List<String> ae = new ArrayList<>();
        ae.add("a");
        listOfSounds.add(ae);

        /*Substrings:   a

          Examples:     cat, apple, land, travel, mad;
                        AmE: last, class, dance, castle, half

          Exceptions:

          Possible Formula: constant + sound + constant

        */

        List<String> a0 = new ArrayList<>();
        a0.add("ar");
        listOfSounds.add(a0);

        /*Substrings:   ar, a

          Examples:     army, car, party, garden, park, father, calm, palm, drama;
                        BrE: last, class, dance, castle, half

          Exceptions:   war, warm [o:]

          Possible Formula: constant + sound + constant //THIS IS THE SAME FORMULA FOR ALL OF THEM

        */

        List<String> ai = new ArrayList<>();
        ai.add("i");
        ai.add("ie");
        ai.add("y");
        ai.add("uy");
        listOfSounds.add(ai);

        /*Substrings:   i, ie, y, uy

          Examples:     ice, find, smile, tie, lie, die, my, style, apply, buy, guy

          Exceptions:

        */

        List<String> au = new ArrayList<>();
        au.add("ou");
        au.add("ow");
        listOfSounds.add(au);

        /*Substrings:   ou, ow

          Examples:     out, about, house, mouse, now, brown, cow, owl, powder

          Exceptions:   group, soup [u:]
                        know, own [ou]

        */

        List<String> o = new ArrayList<>();
        o.add("o");
        listOfSounds.add(o);

        /*Substrings:   o

          Examples:     not, rock, model, bottle, copy

          Exceptions:

        */

        List<String> o0 = new ArrayList<>();
        o0.add("or");
        o0.add("o");
        o0.add("aw");
        o0.add("au");
        o0.add("ought");
        o0.add("al");
        o0.add("wa-");
        listOfSounds.add(o0);

            //How does "or" rhyme with "ought"??

        /*Substrings:   or, o, aw, au, ought, al, wa-

          Examples:     more, order, cord, port, long, gone, cost, coffee,
                        law, saw, pause, because, bought, thought, caught,
                        hall, always, water, war, want

          Exceptions:   work, word [ər]

        */

        List<String> oi = new ArrayList<>();
        oi.add("oi");
        oi.add("oy");
        listOfSounds.add(oi);

        /*Substrings:   oi, oy

          Examples:     oil, voice, noise, boy, toy

          Exceptions:

        */

        List<String> ou = new ArrayList<>();
        ou.add("o");
        ou.add("oa");
        ou.add("ow");
        listOfSounds.add(ou);


        /*Substrings:   o, oa, ow

          Examples:     go, note, open, old, most, road, boat, low, own, bowl

          Exceptions:   do, move [u:]
                        how, owl [au]

        */

        List<String> yu0 = new ArrayList<>();
        yu0.add("u");
        yu0.add("ew");
        yu0.add("eu");
        yu0.add("ue");
        yu0.add("ui");
        listOfSounds.add(yu0);

        /*Substrings:   u, ew, eu, ue, ui

          Examples:     use, duty, music, cute, huge, tune, few, dew, mew, new,
                        euphemism, feud, neutral, hue, cue, due, sue, suit

          Exceptions:

        */

        List<String> u0 = new ArrayList<>();
        u0.add("u");
        u0.add("o");
        u0.add("oo");
        u0.add("ew");
        u0.add("ue");
        u0.add("ui");
        u0.add("ou");
        listOfSounds.add(u0);

        /*Substrings:   u, o, oo, ew, ue, ui, ou

          Examples:     rude, Lucy, June, do, move, room, tool, crew, chew, flew, jewel,
                        blue, true, fruit, juice, group, through, route;
                        AmE: duty, new, sue, student

          Exceptions:   guide, quite [ai];
                        build [i]
        */

        List<String> u = new ArrayList<>();
        u.add("oo");
        u.add("u");
        u.add("ou");
        listOfSounds.add(u);

        /*Substrings:   oo, u, ou

          Examples:     look, book, foot, good, put, push, pull, full, sugar, would, could, should

          Exceptions:

        */

        List<String> naturalSounds = new ArrayList<>();
        naturalSounds.add("u");
        naturalSounds.add("o");
        naturalSounds.add("ou");
        naturalSounds.add("a");
        naturalSounds.add("e");
        naturalSounds.add("o");
        naturalSounds.add("i");
        listOfSounds.add(naturalSounds);

        /*Substrings:   u, o, ou, a, e, o, i

          Examples:     gun, cut, son, money, love, tough, enough, rough,
                        about, brutal, taken, violent,
                        memory, reason, family

          Exceptions:

        */

        List<String> er = new ArrayList<>();
        er.add("er");
        er.add("ur");
        er.add("ir");
        er.add("or");
        er.add("ar");
        er.add("ear");
        listOfSounds.add(er);

        /*Substrings:   er, ur, ir, or, ar, ear

          Examples:     serve, herb, burn, hurt, girl, sir, work, word, doctor, dollar,
                        heard, earn, earnest, earth

          Exceptions:   heart, hearth [a:]

        */


        //Need sounds for the following constants. "f/ph", "c/k/ch"

        return listOfSounds;

    }

}
