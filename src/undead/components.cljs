(ns undead.components
	(:require [cljs.core.async :refer [put!]]
	         [reagent.core :as r]))

(defn Cell [tile reveal-ch]
;;  ^{:key (:id tile)}
    [:div {:class "cell"}
;;    ^{:key (str "tile" (:id tile))}
	   [:div {:class (str "tile"
	                (when (:revealed? tile) " revealed")
	                (when (:matched? tile) " revealed"))
	         :on-click (fn [e]
	                    (.preventDefault e)
	                    (put! reveal-ch (:id tile)))}
;;	   ^{:key (str "front" (:id tile))}
		  [:div {:class "front"}]
;;		^{:key (str "back" (:id tile))}
		  [:div {:class (str "back " (when (:face tile)
		                            (name (:face tile))))}]]]) 
	  
(defn Line [tiles reveal-ch]
;;  ^{:key index}
  [:div {:class "line"}
    (map #(Cell % reveal-ch) tiles)])

(defn Board [tiles reveal-ch]
  [:div {:class "board clearfix"}
    (map #(Line % reveal-ch) (partition 4 tiles))])
	 
(defn Timer [index sand]
  ^{:key (str "timer" index)} [:div {:class (str "timer timer-" index)}
    (map-indexed (fn [index sand] ^{:key index}[:div {:class (str "sand " (name sand))}]) sand)
  ])
(defn Timers [sand]
  [:div {}
    (map-indexed Timer (partition 30 sand))]
)

(defn Game [game reveal-ch]
  [:div {:class (when (:foggy? game) "foggy")}
    (Board (:tiles game) reveal-ch)
	 (Timers (:sand game))
  ])

(defn render-game [game container reveal-ch]
  (r/render-component [Game game reveal-ch] container))
  