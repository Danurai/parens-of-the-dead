(ns undead.client
  (:require [undead.components :refer [render-game]]))

(def container (.getElementById js/document "main"))

(def game 
      {:tiles [{:face :h1} {:face :h1} {:face :h2} {:face :h2 :revealed? true}
             {:face :h3} {:face :h3} {:face :h4 :matched? true} {:face :h4 :matched? true}
				 {:face :h5} {:face :h5} {:face :fg} {:face :fg}
				 {:face :zo} {:face :zo} {:face :zo} {:face :gy}]
	  :sand (concat 
				(repeat 20 :gone)
				(repeat 3 :zombie)
	         (repeat 67 :remaining))
	  :foggy? false})

(render-game game container)
