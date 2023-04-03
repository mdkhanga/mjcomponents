import Link from "next/link"
import Layout from "../../components/Layout"

export default function AboutPage() {
    return <Layout title="About MyFinance"> 
            <h1> This is the myfinance about page </h1> 
            <p>This is an application to manage personal finance.</p>
            <p>version 0.0.1</p>

            <Link href="/"> Home</Link>
        </Layout>
}