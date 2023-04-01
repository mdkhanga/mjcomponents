import Link from "next/link"


export default function HomePage() {
  return (
    <div> 
      <h1> Welcome to the myfinance application </h1>
      <Link href="/about"> About</Link> <br/>
      <Link href="/accounts"> Accounts</Link>
    </div>

  )
}
