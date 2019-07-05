(ns image-gen.image-generator
  (:import
   [javax.imageio ImageIO]
   [java.io File]
   [java.awt.image BufferedImage]))

(defn img-of
  [width height data]
  (let [img (BufferedImage. width
                            height
                            (. BufferedImage TYPE_USHORT_GRAY))]
    (doseq [w (range width)]
      (map #(set-pixel w %1 %2) (range height) (take height (drop w data))))
    img))

(defn set-pixel
  [img x y pixel]
  (. img setRGB x y pixel)
  img)

(defn write
  [^BufferedImage img path name]
  (. ImageIO (write img "png" (File. (str path "/" name ".png")))))

(write (img-of 10 1000 [(range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      (range 1000)
                      ]) "./" "test")

