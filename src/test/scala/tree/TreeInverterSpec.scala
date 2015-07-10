package tree

import org.scalatest.{Matchers, WordSpec}

class TreeInverterSpec extends WordSpec with Matchers {

  "Tree inverter" should {
    import TreeInverter._

    "invert example tree" in {

      val givenTree = TreeNode(1, Some(TreeNode(2, Some(TreeNode(4, None, None)), Some(TreeNode(5, None, None)))), Some(TreeNode(3, Some(TreeNode(6, None, None)), Some(TreeNode(7, None, None)))))
      val expectedTree = TreeNode(1, Some(TreeNode(3, Some(TreeNode(7, None, None)), Some(TreeNode(6, None, None)))), Some(TreeNode(2, Some(TreeNode(5, None, None)), Some(TreeNode(4, None, None)))))

      invert(givenTree) shouldBe expectedTree
    }

    "invert singleton tree" in {

      val tree = TreeNode(1, None, None)

      invert(tree) shouldBe tree
    }

    "invert left skewed tree" in {

      val givenTree = TreeNode(1, Some(TreeNode(2, Some(TreeNode(4, None, None)), None)), None)
      val expectedTree = TreeNode(1, None, Some(TreeNode(2, None, Some(TreeNode(4, None, None)))))

      invert(givenTree) shouldBe expectedTree
    }
  }
}
