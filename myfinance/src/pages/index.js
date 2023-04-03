import Layout from "../../components/Layout"
import Link from 'next/link'


export default function HomePage() {
  return (
    <Layout> 
      <h1> Welcome to the myfinance application </h1>
      <Link href="/about"> About</Link> <br/>
      <Link href="/accounts"> Accounts</Link>
    </Layout>

  )
}
