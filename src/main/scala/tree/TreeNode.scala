package tree

case class TreeNode(value: Int, left: Option[TreeNode], right: Option[TreeNode])

object TreeInverter {

  def invert(tree: TreeNode): TreeNode = tree match {
    case TreeNode(v, None, None) => TreeNode(v, None, None)
    case TreeNode(v, left, right) => TreeNode(v, right.map(invert), left.map(invert))
  }
}
