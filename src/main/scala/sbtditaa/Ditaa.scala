package sbtditaa

import java.io.File

import org.stathissideris.ascii2image.core.ConversionOptions
import org.stathissideris.ascii2image.text.TextGrid
import org.stathissideris.ascii2image.graphics.{BitmapRenderer, Diagram}
import java.awt.image.RenderedImage
import java.nio.file.Files
import javax.imageio.ImageIO
import scala.collection.JavaConverters._


object Ditaa {

  def generateDiagrams(source: File, dest: File) : File = {
    getFileTree(source).foreach { f =>
      generateOneDiagram(f, dest)
    }
    dest
  }

  val bitmapRenderer = new BitmapRenderer()

  def getFileTree(f: File): Seq[File] = {
    java.nio.file.Files.walk(f.toPath).iterator().asScala.filter(Files.isRegularFile(_)).toSeq.map(_.toFile)
  }

  def generateOneDiagram(source: File, dest: File) : File = {
    val options = new ConversionOptions()
    val grid = new TextGrid()
    options.renderingOptions.setAntialias(false)
    options.renderingOptions.setDropShadows(false)
    options.processingOptions.setPerformSeparationOfCommonEdges(false)
    options.renderingOptions.setScale(1.0f)
    options.processingOptions.setAllCornersAreRound(false)
    grid.loadFrom(source.getAbsolutePath)
    val diagram = new Diagram(grid, options)

    dest.mkdirs()

    val image: RenderedImage = bitmapRenderer.renderToImage(diagram, options.renderingOptions)

    ImageIO.write(image, "png", new File(dest, source.getName.replace(".ditaa", ".png")))
    dest
  }

}
