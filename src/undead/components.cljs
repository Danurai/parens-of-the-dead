(ns undead.components
	(:require [reagent.core :as r]))

(defn Cell [index tile]
  ^{:key index}[:div {:class "cell"}
    ^{:key (str "tile" index)}[:div {:class (str "tile"
	                  (when (:revealed? tile) " revealed")
	                  (when (:matched? tile) " revealed"))}
	   ^{:key (str "front" index)}[:div {:class "front"}]
		^{:key (str "back" index)}[:div {:class (str "back " (name (:face tile)))}]]]
) 
	  
(defn Line [index tiles]
  ^{:key index}[:div {:class "line"}
    (map-indexed Cell tiles)])
	 
(defn Timer [index sand]
  ^{:key (str "timer" index)} [:div {:class (str "timer timer-" index)}
    (map-indexed (fn [index sand] ^{:key index}[:div {:class (str "sand " (name sand))}]) sand)
  ])

(defn Timers [sand]
  [:div {}
    (map-indexed Timer (partition 30 sand))]
)

(defn Board [tiles]
  [:div {:class "board clearfix"}
    (map-indexed Line (partition 4 tiles))])

(defn Game [game]
  [:div {:class (when (:foggy? game) "foggy")}
    (Board (:tiles game))
	 (Timers (:sand game))
  ])

(defn render-game [game container]
  (r/render-component [Game game] container))
  